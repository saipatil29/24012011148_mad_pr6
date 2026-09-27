# MAD Practical 6 – Alarm Application

## Practical 6: Alarm using Broadcast Receiver, Service and AlarmManager

This practical is an Android application developed for the **Mobile Application Development (MAD)** subject.

The application allows the user to **create an alarm for a selected time and cancel the alarm**. When the selected time is reached, an Android `BroadcastReceiver` receives the alarm event and starts an `AlarmService`, which plays the alarm sound.

## Student Details

- **Student ID:** 24012011148
- **Practical:** 6
- **Subject:** Mobile Application Development
- **Platform:** Android
- **Language:** Kotlin
- **IDE:** Android Studio

## Objective

The main objective of this practical is to understand and implement:

- `AlarmManager`
- `BroadcastReceiver`
- Android `Service`
- `PendingIntent`
- `TimePickerDialog`
- `MediaPlayer`
- Drawable and view animations
- Exact alarm scheduling

## Working of the Application

The application works in the following way:

1. The app starts with a **splash screen** containing an animated logo.
2. After the splash animation, the main alarm screen is opened.
3. The user clicks **Create Alarm**.
4. A `TimePickerDialog` is displayed.
5. The user selects the required alarm time.
6. `AlarmManager` schedules the alarm using a `PendingIntent`.
7. When the scheduled time is reached, `AlarmBroadcastReciver` receives the broadcast.
8. The receiver starts `AlarmService`.
9. `AlarmService` uses `MediaPlayer` to play the alarm sound.
10. The user can use **Cancel Alarm** to stop the scheduled alarm/service.

## Main Components

### 1. MainActivity

`MainActivity.kt` is responsible for the main user interface and alarm creation.

It:

- Shows the time picker.
- Gets the selected hour and minute.
- Creates the alarm using `AlarmManager`.
- Displays the selected alarm time.
- Provides Create Alarm and Cancel Alarm buttons.
- Starts the alarm and heart animations.

### 2. AlarmBroadcastReciver

`AlarmBroadcastReciver.kt` is a `BroadcastReceiver`.

It receives the alarm broadcast and checks whether the received action is:

- `start` – starts the alarm service.
- `stop` – stops the alarm service.

### 3. AlarmService

`AlarmService.kt` is an Android Service used to play the alarm sound.

It uses:

```text
MediaPlayer
```

to play the audio file stored in:

```text
res/raw/alarm.mp4
```

### 4. SplashActivity

`SplashActivity.kt` displays the splash screen when the application starts.

It uses:

- Drawable animation
- Twin animation
- Animated UVPCE logo

After the animation finishes, it opens `MainActivity`.

## Android Concepts Used

| Concept | Purpose |
|---|---|
| AlarmManager | Schedules the alarm |
| PendingIntent | Delivers the alarm event |
| BroadcastReceiver | Receives the alarm broadcast |
| Service | Runs the alarm sound |
| MediaPlayer | Plays the alarm audio |
| TimePickerDialog | Allows the user to select alarm time |
| AnimationDrawable | Creates frame-based animations |
| AnimationUtils | Loads the splash animation |
| Toast | Displays short messages to the user |

## Project Structure

```text
24012011148_mad_pr6/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/a24012011148_practical_6/
│           │       ├── MainActivity.kt
│           │       ├── SplashActivity.kt
│           │       ├── AlarmService.kt
│           │       └── AlarmBroadcastReciver.kt
│           │
│           ├── res/
│           │   ├── anim/
│           │   ├── drawable/
│           │   ├── layout/
│           │   ├── mipmap/
│           │   └── raw/
│           │
│           └── AndroidManifest.xml
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
└── gradlew.bat
```

## Permissions

The application uses the following permissions:

```xml
<uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```

The exact alarm permission is used so that the application can schedule an alarm at the selected time on supported Android versions.

## How to Run

1. Open the project in **Android Studio**.
2. Wait for Gradle Sync to complete.
3. Connect an Android phone or start an emulator.
4. Click **Run ▶**.
5. Open the application.
6. Select a time using **Create Alarm**.
7. Wait until the selected time to test the alarm.
8. Use **Cancel Alarm** if you want to cancel it.

## Expected Output

The application displays:

- An animated splash screen.
- An alarm screen with animations.
- A Create Alarm button.
- A Cancel Alarm button.
- The selected alarm time.
- An alarm sound when the scheduled time is reached.

## Conclusion

This practical demonstrates how different Android components can work together to create an alarm application. It provides practical understanding of **AlarmManager, BroadcastReceiver, Service, PendingIntent, MediaPlayer, TimePickerDialog and Android animations**.

---
**MAD Practical 6 | Student ID: 24012011148**
