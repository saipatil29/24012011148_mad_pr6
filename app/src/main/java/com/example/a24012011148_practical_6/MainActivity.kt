package com.example.a24012011148_practical_6

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var alarmanimation: AnimationDrawable
    lateinit var heartanimation: AnimationDrawable
    lateinit var textAlarm: TextView
    lateinit var cardSetAlarm: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        cardSetAlarm = findViewById(R.id.cardSetAlarm)
        textAlarm = findViewById(R.id.textAlarm)

        val alarm: ImageView = findViewById(R.id.alarmImage)
        alarm.setBackgroundResource(R.drawable.alarm_frame_anim)
        alarmanimation = alarm.background as AnimationDrawable

        val heart: ImageView = findViewById(R.id.heartIcon)
        heart.setBackgroundResource(R.drawable.ic_heart_outline)
        heartanimation = heart.background as AnimationDrawable

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.createAlarmButton).setOnClickListener {
            showTimeDialog()
        }
        findViewById<Button>(R.id.cancelAlarmButton).setOnClickListener {
            setAlarm(0, AlarmBroadcastReciver.STOP_VAL)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            alarmanimation.start()
            heartanimation.start()
        } else {
            alarmanimation.stop()
            heartanimation.stop()
        }
    }

    private fun showTimeDialog() {
        val cldr: Calendar = Calendar.getInstance()
        val hrs: Int = cldr.get(Calendar.HOUR_OF_DAY)
        val mns: Int = cldr.get(Calendar.MINUTE)
        val picker = TimePickerDialog(
            this,
            { _, sHour, sMinute -> sendDialogDataToActivity(sHour, sMinute) },
            hrs,
            mns,
            false
        )
        picker.show()
    }

    private fun sendDialogDataToActivity(hour: Int, minute: Int) {
        val alarmCalendar = Calendar.getInstance()
        val year: Int = alarmCalendar.get(Calendar.YEAR)
        val month: Int = alarmCalendar.get(Calendar.MONTH)
        val day: Int = alarmCalendar.get(Calendar.DATE)
        alarmCalendar.set(year, month, day, hour, minute, 0)

        val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute)
        Toast.makeText(
            this,
            "Time : $formattedTime, millis:${alarmCalendar.timeInMillis}",
            Toast.LENGTH_SHORT
        ).show()

        if (setAlarm(alarmCalendar.timeInMillis, AlarmBroadcastReciver.START_VAL)) {
            textAlarm.text = formattedTime
            cardSetAlarm.visibility = View.VISIBLE
        }
    }

    fun setAlarm(millisTime: Long, str: String): Boolean {
        val intent = Intent(this, AlarmBroadcastReciver::class.java)
        intent.putExtra(AlarmBroadcastReciver.SERVICE_KEY, str)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            23535612,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        if (str == AlarmBroadcastReciver.START_VAL) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (alarmManager.canScheduleExactAlarms()) {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        millisTime,
                        pendingIntent
                    )
                    return true
                } else {
                    Toast.makeText(this, "Alarm not scheduled - exact alarm permission needed", Toast.LENGTH_SHORT).show()
                    Intent(
                        Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM,
                        "package:$packageName".toUri()
                    ).apply { startActivity(this) }
                    return false
                }
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    millisTime,
                    pendingIntent
                )
                return true
            }
        } else if (str == AlarmBroadcastReciver.STOP_VAL) {
            alarmManager.cancel(pendingIntent)
            sendBroadcast(intent)
            Toast.makeText(this, "Alarm is stopped", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}