<h2 align="center"><b>SettingsCompose</b></h2>
<h4 align="center">A Jetpack Compose implementation of Settings Fragment</h4>

<p align="center"><a href="#screenshots">Screenshots</a> &bull; <a href="#description">Description</a> &bull; <a href="#features">Features</a> &bull; <a href="#libraries">Libraries Used</a>

[![](https://jitpack.io/v/laksh-21/SettingsCompose.svg)](https://jitpack.io/#laksh-21/SettingsCompose)

## Description
Since `Jetpack Compose` does not provide any libraries for `Preferences` and it also uses `SharedPreferences` which have been
deprecated, this implementation solves both these issues by using `Preferences Datastore`

### Features
* Uses Preferences Datastore
* SettingsCheckbox: Checkbox Preference
* SettingsSwitch: Switch Preference
* SettingsGroup: Group of Preferences
* SettingsList: Single select List Preference
* SettingsMultiList: Multi select List Preference
* SettingsScreen: Parent screen for all preferences

### Libraries
* [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI
* [Preferences Datastore](https://developer.android.com/topic/libraries/architecture/datastore)- Data Persistence

### Project Setup

To add Settings-Compose to your project:
Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }


Add the dependency:

    dependencies {
        implementation 'com.github.laksh-21:SettingsCompose:0.1.0'
    }

Now to use the library, one first needs to create a `Preferences Datastore` instance and a `DatastoreManager` instance using that:

    val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    val datastoreManager = DatastoreManager(datastore = this.datastore)

Then, you can provide the instance to the `SettingsScreen`:

    SettingsScreen(datastoreManager = datastoreManager) {
        ...
    }

Now you're ready to use all the components of the library inside the scope of `SettingsScreen`.

For every single component, you need to provide a `SettingReference` like:
* `CheckboxReference`: uses a `Boolean` value
* `SwitchReference`: uses a `Boolean` value
* `ListReference`: uses a `String` value
* `MultiListReference`: uses a `Set<String>` value

To create such reference, the key is a `Preferences.Key<T>` type value and default value is a `<T>` type value:

    CheckboxReference(key = booleanPreferencesKey(name = "checkBoxName"), defaultValue = false)

The same reference can be used to query the current value of the Setting
