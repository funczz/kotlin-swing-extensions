# kotlin-swing-extensions

## Using Gradle

In your build.gradle.kts.

```kotlin
repositories {
    maven { setUrl("https://funczz.github.io/kotlin-swing-extensions") }
}
dependencies {
    implementation("com.github.funczz:swing-extensions:<VERSION>")
}
```

## Demo

```console
./gradlew run -DmainClass=DEMO_CLASS
```

Demo class:

* AbstractFutureReadableTableModelDemo
* AlternateRowBackgroundJTableDemo
* BgImagePainterDemo
* CharAnimatedIconLabelDemo
* CircleAnimatedIconLabelDemo
* FunctionalActionDemo
* FunctionalDocumentListenerDemo
* FunctionalMouseAdapterDemo
* FunctionalSwingWorkerDemo
* GridBagTableLayoutDemo
* JComponentListCellRendererDemo
* JPanelListDemo
* JTableHeaderDemo
* JTableHeaderWithoutJScrollPaneDemo
* TableRowSorterDemo
* TextAnimatedIconLabelDemo
* ToastDemo
