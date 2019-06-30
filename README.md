# VCParkingSlot

Android Projects Bundled with apps and independent library. Support API 28 and AppCompat V7

## Getting Started

Library Path is On 
```
/vcparkingslot
```

Compiled Library Path is at
```
/vcparkingslot/build/outputs/aar/
```

And also Compiled APK Path is at
```
/app/build/outputs/apk/debug/ or /app/build/outputs/apk/release/
```

To Starting Open The Projects
```
Open Folder (Project Folder) With Android Studio and Run With AVD or Actual Devices
```

## Implementation

The Integrated Library Would have dynamic way to start their activities.

The Important step is Import The Library file to android app project to
```
/name_of_apps/Libs/vcparkingslot-debug.aar or /name_of_apps/Libs/vcparkingslot-release.aar
```
And Importing Pragmatically
```
import com.example.vcparkingslot.VCParkingSlot;

public class MainActivity extends AppCompatActivity {

    VCParkingSlot vcParkingSlot = new VCParkingSlot();

    ...
}

```

Replacing the current activity will follow this code on MainActivity
```
Intent intent = new Intent(this.Context, ThePluginsReference.Activity_().getClass());
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_HOME);
startActivity(intent);
this.finish();
```

Start the new activity will write this
```
Intent intent = new Intent(this.Context, ThePluginsReference.Activity_().getClass());
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(intent);
```