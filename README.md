

24012011147_Practical_6-master(1).zip
Zip Archive

69b70809-b8fd-4df7-ba7f-a457a63e1a37.png
why thiis is happning with ur file everyytimeeee

5b7d0db1-f1f4-4db6-aab3-cb18d767293c.png
we have to change that module name 

7eb41608-c46b-4daf-85ad-00137c588cb5.png
why i cant upload this on git

6289e451-d24c-4046-b3c9-ff7c9fde56ad.png

1f0c4d20-9a6f-4251-8be8-24837b0735ca.png

ba67da54-a242-41cb-8c70-4ee1d4117286.png

Done. Here is the README.md ready to upload directly to your GitHub repository:


To add it to GitHub
Open your repository → Add file → Upload files → select README.md → Commit changes.

It already includes the project name, MAD practical details, requirements, run instructions, project structure, author, and GitHub repository. 




24012011148_mad_pr6-main.zip
Zip Archive
here is the filr

Yes 👍 I got the project file.

I added the README.md directly inside your project ZIP.


You can extract it and upload the whole project to GitHub.


i want readme file what is this

Ahh yes 😅 You want ONLY the README.md file, not the whole project ZIP.

Here it is:

📄 README.md

Upload this one file directly to your GitHub repository:

GitHub → Add file → Upload files → select README.md → Commit changes.




24012011148_mad_pr6-main(1).zip
Zip Archive
i want readme file about my practical 

Yes — this README is specifically about your Practical 6, based on the actual files/code in the project you uploaded.

It covers:

AlarmManager

BroadcastReceiver

Service

MediaPlayer

TimePicker

PendingIntent

Splash/animations

How the practical works

Project structure

Permissions

How to run it

📄 Your Practical 6 README

Upload only this README.md to your GitHub repository. 



README.md


MAD Practical 6 – Alarm Application
Practical 6: Alarm using Broadcast Receiver, Service and AlarmManager
This practical is an Android application developed for the Mobile Application Development (MAD) subject.

The application allows the user to create an alarm for a selected time and cancel the alarm. When the selected time is reached, an Android BroadcastReceiver receives the alarm event and starts an AlarmService, which plays the alarm sound.

Student Details
Student ID: 24012011148

Practical: 6

Subject: Mobile Application Development

Platform: Android

Language: Kotlin

IDE: Android Studio

Objective
The main objective of this practical is to understand and implement:

AlarmManager

BroadcastReceiver

Android Service

PendingIntent

TimePickerDialog

MediaPlayer

Drawable and view animations

Exact alarm scheduling

Working of the Application
The application works in the following way:

The app starts with a splash screen containing an animated logo.

After the splash animation, the main alarm screen is opened.

The user clicks Create Alarm.

A TimePickerDialog is displayed.

The user selects the required alarm time.

AlarmManager schedules the alarm using a PendingIntent.

When the scheduled time is reached, AlarmBroadcastReciver receives the broadcast.

The receiver starts AlarmService.

AlarmService uses MediaPlayer to play the alarm sound.

The user can use Cancel Alarm to stop the scheduled alarm/service.

Main Components
1. MainActivity
MainActivity.kt is responsible for the main user interface and alarm creation.

It:

Shows the time picker.

Gets the selected hour and minute.

Creates the alarm using AlarmManager.

Displays the selected alarm time.

Provides Create Alarm and Cancel Alarm buttons.

Starts the alarm and heart animations.

2. AlarmBroadcastReciver
AlarmBroadcastReciver.kt is a BroadcastReceiver.

It receives the alarm broadcast and checks whether the received action is:

start – starts the alarm service.

stop – stops the alarm service.

3. AlarmService
AlarmService.kt is an Android Service used to play the alarm sound.

It uses:

MediaPlayer
to play the audio file stored in:

res/raw/alarm.mp4
4. SplashActivity
SplashActivity.kt displays the splash screen when the application starts.

It uses:

Drawable animation

Twin animation

Animated UVPCE logo

After the animation finishes, it opens MainActivity.

Android Concepts Used
Concept	Purpose
AlarmManager	Schedules the alarm
PendingIntent	Delivers the alarm event
BroadcastReceiver	Receives the alarm broadcast
Service	Runs the alarm sound
MediaPlayer	Plays the alarm audio
TimePickerDialog	Allows the user to select alarm time
AnimationDrawable	Creates frame-based animations
AnimationUtils	Loads the splash animation
Toast	Displays short messages to the user
Project Structure
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
Permissions
The application uses the following permissions:

<uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
The exact alarm permission is used so that the application can schedule an alarm at the selected time on supported Android versions.

How to Run
Open the project in Android Studio.

Wait for Gradle Sync to complete.

Connect an Android phone or start an emulator.

Click Run ▶.

Open the application.

Select a time using Create Alarm.

Wait until the selected time to test the alarm.

Use Cancel Alarm if you want to cancel it.

Expected Output
The application displays:

An animated splash screen.

An alarm screen with animations.

A Create Alarm button.

A Cancel Alarm button.

The selected alarm time.

An alarm sound when the scheduled time is reached.

Conclusion
This practical demonstrates how different Android components can work together to create an alarm application. It provides practical understanding of AlarmManager, BroadcastReceiver, Service, PendingIntent, MediaPlayer, TimePickerDialog and Android animations.

MAD Practical 6 | Student ID: 24012011148

