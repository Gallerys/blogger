<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    tools:context=".MainActivity"
    tools:ignore="UseCompoundDrawables">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="100dp"
        android:layout_marginStart="100dp"
        />

    <TextView
        android:id="@+id/scoreId"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="@string/scoreText"
        android:textSize="24sp"
        android:textStyle="italic"
        android:gravity="center"
        android:layout_margin="20dp"/>

    <ImageView
        android:id="@+id/mainSpinnerId"
        android:layout_width="400dp"
        android:layout_height="400dp"
        android:src="@drawable/spinner"
        android:contentDescription="@string/spinnerImage" />

</LinearLayout>
