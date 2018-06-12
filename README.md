# helpdroid
Android toolbox code
====
[![](https://jitpack.io/v/Ehsanmashhadi/helpdroid.svg)](https://jitpack.io/#Ehsanmashhadi/helpdroid)

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
compile 'com.github.ehsanmashhadi:helpdroid:$version'
```
### Application
* AppSigner
    - digest of application sign SHA1, SHA256, SHA512
* Version
    - version code
    - version name
    
### Device
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

### String
* StringConverter
    - hexStringToBytes
    - bytesToHexString

### UI
* Keyboard
    - hide keyboard
    - show keyboard
    - setup soft keyboard (dismiss keyboard when touching outside of it)
* Snackbar
* UnitConverter
    - dp to px
    - px to db
 
 ### Util
 * Parser
    - parse jwt
 * Screen Locker
 * Shamsi calendar
 
 ### Validation
 * Validator
    - email validator
    - phone validator
    - password validator
### Test
* Ordered test case
