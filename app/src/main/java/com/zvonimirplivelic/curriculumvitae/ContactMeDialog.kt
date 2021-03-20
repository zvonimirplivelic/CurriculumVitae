package com.zvonimirplivelic.curriculumvitae

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDialog
import de.cketti.mailto.EmailIntentBuilder


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

        ibEmail!!.setOnClickListener {
            onContactMeDialogListener.contactMeEmail()
        }

        ibPhone!!.setOnClickListener {
            onContactMeDialogListener.contactMePhone()
        }

    }
}