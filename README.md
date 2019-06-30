# VCParkingSlot

Android Projects Bundled with apps and independent library. Support API 28 and AppCompat V7

## Getting Started

Library Path is On 
```
/vcparkingslot
```

To Starting Open The Projects
```
Open Folder (Project Folder) With Android Studio and Run With AVD or Actual Devices
```

## Implementation

The Integrated Library Would have dynamic way to start their activities.

Replacing the current activity will follow this code
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