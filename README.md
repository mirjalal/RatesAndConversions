# ![][app_logo] Rates & Conversions

[![mirjalal](https://circleci.com/gh/mirjalal/RatesAndConversions.svg?style=shield)](https://circleci.com/gh/mirjalal/RatesAndConversions)


Made with :heart: in Azerbaijan.


## Screenshots

|          Loading screen           |         Main screen         |             Enter amount screen             |           New rates screen            |         Error screen          |
|:---------------------------------:|:---------------------------:|:-------------------------------------------:|:-------------------------------------:|:-----------------------------:|
| ![Loading screen][loading_screen] | ![Main screen][main_screen] | ![Enter amount screen][enter_amount_screen] | ![New rates screen][new_rates_screen] | ![Error screen][error_screen] |


## Architecture

The [recommended app architecture][app_arch_overview] applied in the
application. However, unfortunately due to time limit there are
deviations. Fixing those 'mistakes' could take a bit more time. You
know, every home task has its deadline. I tried to do my best for this
project, could not achieved it hundred per-cent.


## Structure of the project

[Root project][root_project] has some several packages (they include app
layers inside of them) and files:
1. [Data package][data_package]
2. [UI package][ui_package]
3. [DI package][di_package]
4. [Helpers package][helpers_package]
5. [Main application][app_class] & [Service Locator][service_locator]
   files

Data package includes [repository][repo_layer] and [remote
source][remote_source_layer] layers as well. DI package has a single
file in it called [koinModules.kt][koin_module]. This file only keeps a
variable in it which is needed to be used in [application
class][app_class]. Helpers package has different kinds of files for
different purposes. [Check them][helpers_package] to get extra
information about them. Finally, UI package keeps main activity, a
[fragment], its [ViewModel] and [other UI related classes/files].
Additionally, [Service Locator][service_locator] file is used to manage
layers from one point.

*NOTE: Additional information about classes/files/functions about their
functionalities were added as comments.*

## Requirements

Android Studio v3.5+, Kotlin v1.3.71 & JDK v8 are enough to build the
project. To build release artifact:
1. Select `Generate Signed Bundle/Apk` option from `Build` menu in your
   IDE.
2. Pick the `rates_conversions_kystr.jks` file as key store fil from
   project root path.
3. Enter `threecowsatthesea` text for all password fields.
4. Enter `rates_conversions` as key store alias and hit next.
5. Check both `V1` and `V2` checkboxes as `Signature Versions` option.
6. Hit `Finish` button & wait for your release app.

Or alternatively, simply run `./gradlew assembleRelease` command in
terminal & wait for successful build report from the gradle.


## Copyrights:

1. [app logo][app_logo] made by [Freepik] from [Flaticon].
2. Country flags in [drawable][country_flags_folder] were downloaded
   from [country flags][country_flags].


[app_logo]: images/app_logo.jpg
[main_screen]: images/main_screen.jpg
[loading_screen]: images/loading_screen.jpg
[enter_amount_screen]: images/main_screen_enter_amount.jpg
[new_rates_screen]: images/main_screen_new_rates.jpg
[error_screen]: images/error_screen.jpg
[app_arch_overview]: https://developer.android.com/jetpack/docs/guide#overview

[root_project]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions
[data_package]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/data
[ui_package]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/ui
[di_package]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/di
[helpers_package]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/helpers
[app_class]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/RatesConversionsApp.kt
[service_locator]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/ServiceLocator.kt
[repo_layer]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/data/repo/RatesConversionsRepository.kt
[remote_source_layer]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/data/remotesource
[koin_module]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/di/koinModules.kt
[fragment]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/ui/main/RatesConversionsFragment.kt
[viewModel]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/ui/main/RatesConversionsFragment.kt
[other UI related classes/files]: ratesAndConversions/src/main/kotlin/aze/talmir/task/ratesconversions/ui/main/adapter
[country_flags_folder]: ratesAndConversions/src/main/res/drawable

[Freepik]: https://www.flaticon.com/authors/freepik
[Flaticon]: https://www.flaticon.com
[country_flags]: https://www.countryflags.com/en/

