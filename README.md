ServiceWear - library for multiple WearableListenerServices
=======

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.tajchert/servicewear/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/pl.tajchert/servicewear)


ServiceWear is very simple library to solve problem of allowing only one instance of `WearableListenerService` on Android Wear devices. So for example you can define only DataAPI related code in one, and second use for handling MessageAPI events or some library like [BusWear](https://github.com/tajchert/BusWear), as many as you wish!

###Add ServiceWear to your project

Gradle:
```gradle
    //library:
    compile 'pl.tajchert:servicewear:0.1.0'
    //needed dependency:
    compile 'com.google.android.gms:play-services-wearable:+'
```

You can add it to both projects or only one, as you wish.
[Maven Central Link](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pl.tajchert%22%20AND%20a%3A%22servicewear%22)

###How to define WearableListenerService?

```java
public class TestListenerOne extends WearServiceReceiver {

    @Override
    public void onMessageReceived(String path, byte[] data) {
        Toast.makeText(mContext, "First receiver!", Toast.LENGTH_SHORT).show();
    }
    //Same for onDataChanged, onPeerConnected, onPeerDisconnected.
}
```

and add in Manifest file:
```XML
<receiver android:name=".TestListenerOne">
    <intent-filter>
        <action android:name="pl.tajchert.servicewear.wearservice" />
    </intent-filter>
</receiver>
```

###How it works?

It is simple, library receives events in one instance of `WearableListenerService`, and propagate them using BroadcastReceiver mechanism. Thanks to that all classes which extends `WearServiceReceiver` will get events.

###Warning!

As it is based on BroadcastReceivers - If you want to use it on production app it is strongly encourage to change action `name` in Manifest file for `WearServiceReceiver` as otherwise two apps using this library will interfere with each other. Also if you want to make it safe for sniffing events - add custom permission (`android:permission` attribute).

###License

ExceptionWear binaries and source code can be used according to the [MIT license](LICENSE).
