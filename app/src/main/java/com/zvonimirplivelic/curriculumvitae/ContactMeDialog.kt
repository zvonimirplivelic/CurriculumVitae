package com.zvonimirplivelic.curriculumvitae

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog


class ContactMeDialog(
    context: Context,
    private var onContactMeDialogListener: ContactMeDialogListener
) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_me_dialog)
        setTitle("Contact me")

        val ibEmail: ImageButton? = findViewById(R.id.ibEmail)
        val ibPhone: ImageButton? = findViewById(R.id.ibPhone)
        val ivCloseDialog: ImageView? = findViewById(R.id.ivCloseDialog)

        ivCloseDialog!!.setOnClickListener {
            dismiss()
        }

        ibEmail!!.setOnClickListener {
            onContactMeDialogListener.contactMeEmail()
        }

        ibPhone!!.setOnClickListener {
            onContactMeDialogListener.contactMePhone()
        }

    }
}