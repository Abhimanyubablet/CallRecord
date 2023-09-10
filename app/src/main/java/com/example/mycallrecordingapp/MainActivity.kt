package com.example.mycallrecordingapp

import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var callRecord: CallRecord

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Initialize the CallRecord instance
        callRecord = CallRecord.Builder(this)
            .setLogEnable(true)
            .setRecordFileName("CallRecorderTestFile")
            .setRecordDirName("CallRecorderTest")
            .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
            .setShowSeed(true)
            .build()

        // Register the CallRecordReceiver in onCreate
        callRecord.startCallReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister the CallRecordReceiver in onDestroy
        callRecord.stopCallReceiver()
    }

    fun StartCallRecordClick(view: View) {
        // Start call recording when the button is clicked
        LogUtils.i(TAG, "StartCallRecordClick")
        // You've already registered the receiver in onCreate, so you don't need to do it here.
    }

    fun StopCallRecordClick(view: View) {
        // Stop call recording when the button is clicked
        LogUtils.i(TAG, "StopCallRecordClick")
        // You've already unregistered the receiver in onDestroy, so you don't need to do it here.
    }


}