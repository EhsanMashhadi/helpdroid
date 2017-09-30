# helpdroid
Android toolbox code
====
[![](https://jitpack.io/v/Carrene/helpdroid.svg)](https://jitpack.io/#Carrene/helpdroid)

### Dependency

Add jitpack.io to root project build.gradle
```android
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }

    }
}
```
Add dependency on module build.gradle
```android
compile 'com.github.Carrene:helpdroid:v0.1.0'
```
### application
* AppSigner
    - digest of application sign SHA1, SHA256, SHA512
* Version
    - version code
    - version name
    
### device
* DeviceUtil
    - connection to internet (Internet permission)
    - device name
    - device time zone
    - device secure id

* FileManager
    - copy (source, destination)
    - delete
* RootChecker
    - isRooted
    - isRootedWithoutBusyBox

### string
* StringConverter
    - hexStringToBytes
    - bytesToHexString

### ui
* Keyboard
    - hide keyboard
    - show keyboard
    - setup soft keyboard (dismiss keyboard when touching outside of it)
* Snackbar
* UnitConverter
    - dp to px
    - px to db
 
 ### util
 * Parser
    - parse jwt
 * Screen Locker
 * Shamsi calendar
 
 ### validation
 * Validator
    - email validator
    - phone validator
    - password validator
