# clean-mvvm-v2

# Description
This is the sample code to apply technology following points below:
+ Clean architecture (app - business - api) reference the clean architecture book by Uncle Bob. Here is the introduction about it https://medium.freecodecamp.org/a-quick-introduction-to-clean-architecture-990c014448d2
+ apply MVVM (Model-View-ViewModel) published by google - Using ViewModel, LiveData, lifecycle. You can view [guideline](https://developer.android.com/jetpack/docs/guide) for more detail
+ Dagger 2 (which implemented by google) - implemented following dependency injection principle.
+ RxJava 2
+ Retrofit 2 and Okhttp 3
+ Navigation component of architecture component.
+ Sample writing unit test for MVVM + clean architecture structure (NOT implemented yet)
+ Migrate to androidX (NOT implemented yet)
+ Kotlin android extensions
+ Code base for validation rules - easy to use and to write unittest

# Will improve
+ Dagger is big compoenent and hasn't been splited into small features
+ Standard unit test for 3 layer (app, business and api)
+ Remove dependency on LiveData in Business layer.
+ Recheck dependency between 3 layer (app, business and api)

# Reference:
+ [Google advance sample code](https://github.com/googlesamples/android-architecture-components)
+ CLEAN ARCHITECTURE: A CRAFTSMAN’S GUIDE TO SOFTWARE STRUCTURE AND DESIGN – ROBERT C. MARTIN book

# Enjoy coding
