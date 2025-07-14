# SHADY 8

A minimalist light meter app for photographers based on the Sunny 16 rule. Assumes ISO 100 and provides an EV (exposure value) offset in simple stop language (e.g., "-1 stop", "+1 stop").

## 📱 Platforms Supported
- iOS (Swift, SwiftUI)
- Android (Kotlin, Jetpack Compose)

## ⚙️ Features
- Simple UI with EV stop offset display
- Uses phone’s built-in light meter or camera
- Fast, no-nonsense exposure reference

## 📦 iOS Setup
1. Open `ios/` folder in **Xcode**
2. Enable camera permission in your iOS simulator/device settings
3. Run the `SHADY8App.swift` entry point

## 🤖 Android Setup
1. Open `android/` folder in **Android Studio**
2. Run `MainActivity.kt` on a real device (light sensor needed)
3. Grant sensor permissions if prompted

## 🧮 How It Works
- Assumes ISO 100
- Sunny 16 baseline = EV 14
- EV calculated using rough lux-to-EV conversion
- App displays how many stops over/under ideal exposure

## 🔓 License
MIT License — Free to use, modify, and share

## ✨ Name Meaning
**SHADY 8** is a nod to the “Sunny 16” rule. When you’re not in the sun, you’re in the shade. 😎