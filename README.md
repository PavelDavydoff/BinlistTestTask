# BinList Test Task

## 📌 Описание

Приложение для поиска информации по BIN (Bank Identification Number). Использует API BinList для получения данных о банковских картах.

## 📷 Скриншоты
<img src="https://github.com/user-attachments/assets/ee295ebe-fee7-40ae-882a-9f2b8ce38a20" alt="Экран поиска" width="300" height="auto" />

<img src="https://github.com/user-attachments/assets/35d4168d-beb0-4351-a326-100f131440b6" alt="Экран истории поиска" width="300" height="auto" />

## 🚀 Функционал

#### Ввод BIN и отправка запроса
#### Получение информации о карте:
- Схема (Visa, MasterCard и др.)
- Бренд
- Длина номера
- Проверка алгоритма Луна (Luhn)
- Тип (кредитная, дебетовая)
- Предоплаченная ли карта
- Страна выпуска
- Банк-эмитент
#### Переход по координатам
#### Переход по ссылке банка
#### Звонок в банк
#### Отображение истории запросов

## 🛠 Технологии

- Язык: Kotlin
- Архитектура: MVVM
- Сетевые запросы: Retrofit + Coroutine
- База данных: Room
- DI: Koin
- Навигация: Android Jetpack Navigation
- UI: xml-разметка
## 📡 API

Приложение использует публичное API BinList: https://lookup.binlist.net/

## 💡 Использование

Введите первые 6–8 цифр номера карты\
Нажмите кнопку "Найти"\
Получите данные о карте

## 🔄 Обновления
1. Добавить обработку ошибок
2. Доработка UI
