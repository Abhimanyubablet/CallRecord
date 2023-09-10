package com.example.mycallrecordingapp

import android.content.Context
import java.util.Date

class MyCallRecordReceiver(callRecord: CallRecord) : CallRecordReceiver(callRecord) {

    override fun onIncomingCallReceived(context: Context, number: String?, start: Date) {
        super.onIncomingCallReceived(context, number, start)
    }
}