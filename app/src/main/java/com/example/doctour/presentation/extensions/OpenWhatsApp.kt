package com.example.doctour.presentation.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openWhatsApp(context: Context) {
    val phoneNumber = "номер_телефона" // Замените на нужный номер телефона WhatsApp
    val message = "Привет, это сообщение из моего приложения!" // Замените на нужное сообщение

    // Формируем URI для отправки сообщения через WhatsApp
    val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=$message")

    // Создаем Intent с ACTION_SEND
    val intent = Intent(Intent.ACTION_SEND, uri)
    intent.setPackage("com.whatsapp") // Указываем пакет WhatsApp

    // Проверяем, доступно ли приложение WhatsApp на устройстве
    if (intent.resolveActivity(context.packageManager) != null) {
        // Запускаем активность WhatsApp
        context.startActivity(intent)
    } else {
        // WhatsApp не установлено, обрабатываем ситуацию по вашему усмотрению
        // например, открываем ссылку на страницу приложения WhatsApp в Google Play
        val playStoreUri = Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
        val playStoreIntent = Intent(Intent.ACTION_VIEW, playStoreUri)
        context.startActivity(playStoreIntent)
    }
}

