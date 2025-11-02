# AMS - fitUA

Android app for the University of Aveiro gym — built as part of the **Análise e Modelação de Sistemas (AMS)** course.  
This was my **first Android project**, so the codebase is intentionally simple and focused on learning.

> **Heads‑up:** The UI was optimized for a **Pixel 4 XL** device. Other screen sizes may have rough edges.

---

## Overview

- Native Android application written in **Java**.
- Simple login flow with a **demo account** (see below).
- Instrumented UI tests recorded/written with **Espresso**.
- Project folder lives under `APP/` in this repo.

> This project is a student exercise and not an official app of the University of Aveiro or its gym.

---

## Tech Stack

- **Language:** Java
- **Build:** Gradle (Android Gradle Plugin)
- **IDE:** Android Studio
- **Testing:** Espresso (Instrumented tests)

---

## Project Structure

```
AMS-fitUA/
├─ APP/                 # Android app module
├─ .gitattributes
└─ README.md
```

> Tip: In Android Studio, the module appears as **APP**. Source code and resources follow the standard
> `app/src/main/java` and `app/src/main/res` structure inside that module.

---

## Getting Started

### Prerequisites
- **Android Studio** (Arctic Fox or newer recommended)
- **Android SDK** & a device/emulator (Pixel 4 XL recommended for best layout parity)

### Clone
```bash
git clone https://github.com/pmacoutinho/AMS-fitUA.git
cd AMS-fitUA
```

### Open & Run
1. Open **Android Studio** → **Open** → select the repo root.
2. Let Gradle sync resolve dependencies.
3. Choose a device/emulator (preferably **Pixel 4 XL**).
4. Click **Run ▶**.

### Build (CLI)
```bash
# From the repo root
./gradlew assembleDebug
```

---

## Testing (Espresso)

You can run the instrumented UI tests from Android Studio (**Run** → **Run…** → select instrumented tests)  
or via Gradle:

```bash
./gradlew connectedAndroidTest
```

---

## Demo Account

Use these credentials to explore the app without creating an account:

- **Username:** `test`
- **Password:** `123`

> Demo data is for local testing only.

---

## Known Limitations

- **Screen sizes:** Optimized for **Pixel 4 XL**; other devices may experience layout issues.
- **Student project:** Scope is intentionally limited; expect rough edges.

---

## Roadmap Ideas

- Improve responsiveness across a wider range of devices.
- Replace placeholder/demo data with a simple local or remote data source.
- Expand test coverage beyond Espresso recordings (page‑object pattern, idling resources).
- CI workflow (GitHub Actions) for build + test.

---

## Contributing

Pull requests are welcome! If you plan a bigger change, consider opening an issue first to discuss what you’d like to change.

---

## 🙏 Acknowledgements

- University of Aveiro & AMS course context
- Android Developers documentation
- Espresso testing tooling
