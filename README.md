Define the ANDROID_HOME environment variable.
Set the sdk.dir path in the local.properties file of your project.
Here are the steps to fix the issue:

Method 1: Define ANDROID_HOME Environment Variable
Find the SDK Location:

Open Android Studio.
Go to File > Settings (or Android Studio > Preferences on macOS).
Navigate to Appearance & Behavior > System Settings > Android SDK.
Note the SDK location.
Set the Environment Variable:

Windows:

Right-click on This PC or Computer on the desktop or in File Explorer.
Select Properties.
Click Advanced system settings.
Click Environment Variables.
Under System variables, click New.
Set the variable name to ANDROID_HOME.
Set the variable value to the path of your Android SDK (noted from the first step).
Click OK to save.
macOS/Linux:

Open a terminal.
Edit your shell profile file (e.g., ~/.bashrc, ~/.zshrc, or ~/.profile).
Add the following line:
sh
Copy code
export ANDROID_HOME=/path/to/your/sdk
Save the file and close the editor.
Run source ~/.bashrc, source ~/.zshrc, or source ~/.profile to apply the changes.
Method 2: Set the sdk.dir in local.properties
Open the local.properties file in your project's root directory. If it does not exist, create it.

Add the following line:

properties
Copy code
sdk.dir=/path/to/your/sdk
Replace /path/to/your/sdk with the actual path to your Android SDK directory.

Save the file.

Example of local.properties file:
properties
Copy code
sdk.dir=C:\\Users\\RC_student_2024\\AppData\\Local\\Android\\Sdk
After setting either the ANDROID_HOME environment variable or the sdk.dir path in local.properties, try rebuilding your project in Android Studio.

If you continue to face issues, you can also run the build with additional logging for more detailed insights:

sh
Copy code
./gradlew assembleDebug --info
or

sh
Copy code
./gradlew assembleDebug --debug
This can provide more information to help diagnose further problems.
