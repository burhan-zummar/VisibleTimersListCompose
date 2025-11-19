# ⏱️ Compose List Timers

An Android Jetpack Compose project that displays a list of 100 items where **each row contains a timer** that starts incrementing **only when the item becomes visible** on screen.

All logic is handled in a **ViewModel**, and the UI observes state updates following MVVM best practices.

---

## 🎯 Features

- 100 list items rendered using `LazyColumn`
- Each item shares the timer
- Timer starts on app launch
- Timer logic is managed inside **ViewModel**
- UI observes state using **Flow/StateFlow**
- Lifecycle-aware implementation
- Fully built with **Jetpack Compose**
