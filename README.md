![Green and Cream Modern Sales Marketing Presentation (1)](https://user-images.githubusercontent.com/81345503/150186323-e0b439ab-f6fa-4ee3-b820-323057572e45.png)
# :link:Open-Source Library
* [Retrofit](https://square.github.io/retrofit/)
* [Dependency Injection](https://developer.android.com/training/dependency-injection/hilt-android)
* [Jetpack](https://developer.android.com/jetpack)
* [Rx-Java](https://reactivex.io/)
* [ViewModel and LiveData](https://developer.android.com/codelabs/basic-android-kotlin-training-livedata#0)
# Things we used while making this application
* MVVM-Architecture
* GitHub
* Retrofit Library
* API
# Tech Stack :sparkles:
* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)
# Clone this Repo To Your System Using Android Studio:sparkles:
* Step 1: Open your Android Studio then go to the File > New > Project from Version Control.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise . In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.
# Clone this Repo To Your System Using GitBash:sparkles:
* Open Git Bash
* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.
* Go to the current directory where you want the cloned directory to be added.
* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.
* Go to the page of the repository that you want to clone
* Click on “Clone or download” and copy the URL.
* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/chekeAditya/Grow-Application
* Press Enter. $ git clone https://github.com/chekeAditya/Grow-Application Cloning into Git … remote: Counting objects: 13, done. remote: Compressing objects: 100% (13/13), done. remove: Total 13 (delta 1), reused 0 (delta 1) Unpacking objects: 100% (13/13), done.
Congratulations, you have created your first local clone from your remote Github repository.
Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.
# Dependencies
    
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
    implementation 'androidx.test.ext:junit-ktx:1.1.3'
    testImplementation 'junit:junit:4.12'
    def anko_version = '0.10.0'

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.0'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.2'

    //Anko
    implementation "org.jetbrains.anko:anko-commons:$anko_version"

    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0-alpha03'

    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    //retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation 'com.squareup.retrofit2:converter-scalars:2.1.0'

    //Okhttp3
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"

    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    implementation 'me.relex:circleindicator:2.1.6'

    //RXjava

    implementation 'io.reactivex.rxjava3:rxjava:3.1.2'
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'
    // Testing
    androidTestImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "org.mockito:mockito-core:2.27.0"

    testImplementation "androidx.arch.core:core-testing:2.1.0"
