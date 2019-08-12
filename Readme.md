# All4114All Kotlin+Dagger2+Rx+Image,Text,File loading library

This app just shows how to use Retrofit,Rx with Kotlin


## Machine Used
- Android Studio v3.5.0-rc02
- Gradle v5.4.1
- Android SDK API 29
- Minimum SDK API 21
- Ubuntu 19.04

## Build 
Import the project in Android Studio File->New->Import Project->All4114All

  
Let the AS build and download all dependencies or Use Build->Rebuild Project

Use Shift+F10 or Run->Run to Run the app in device/emulator

Make sure you [enabled adb debugging][enable-adb] on your device(s).

[enable-adb]: https://developer.android.com/studio/command-line/adb.html#Enabling

## Run Test
#### Unit Test

#### Instrumentation Test

## How to Use Fetch?
#### Fetch Image
```
   Fetch.asImage().eneque(
                   ImageRequest(
                       url,
                       MediaType.IMAGE
                   ).apply {
                   callback = { bmp ->
                       if (bmp.width > 0 && bmp.height > 0)
                           binding.imageView.setImageBitmap(bmp)
                       else binding.imageView.setImageResource(R.mipmap.ic_avatar)
                   }
               })

```

#### Fetch Text
```
   Fetch.asText().eneque(
                   TextRequest(
                       url,
                       MediaType.TEXT
                   ).apply {
                   callback = { text ->
                       //handle Text, parse JSON,XML or anything
                   }
               })

```

#### Fetch File(pdf,zip or any stream)
```
   Fetch.asFile().eneque(
                   FileRequest(
                       url,
                       MediaType.FILE
                   ).apply {
                   callback = { stream ->
                       //handle stream, convert or write into file. 
                   }
               })

```
