package com.zvonimirplivelic.curriculumvitae

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import de.cketti.mailto.EmailIntentBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personalInformationCard: CardView =
            findViewById(R.id.personalInformationCard)
        val workExperienceCard: CardView =
            findViewById(R.id.workExperienceCard)
        val educationCard: CardView =
            findViewById(R.id.educationCard)
        val personalSkillsCard: CardView =
            findViewById(R.id.personalSkillsCard)

        val personalInformationExpandable: LinearLayout =
            findViewById(R.id.expandablePersonalInformation)
        val workExperienceExpandable: LinearLayout =
            findViewById(R.id.expandableWorkExperience)
        val educationExpandable: LinearLayout =
            findViewById(R.id.expandableEducation)
        val personalSkillsExpandable: LinearLayout =
            findViewById(R.id.expandablePersonalSkills)

        val personalInformationImageButton: ImageButton =
            findViewById(R.id.personalInformationImageButton)
        val workExperienceImageButton: ImageButton =
            findViewById(R.id.workExperienceImageButton)
        val educationCardImageButton: ImageButton =
            findViewById(R.id.educationImageButton)
        val personalSkillsCardImageButton: ImageButton =
            findViewById(R.id.personalSkillsImageButton)

        val contactMeButton: Button =
            findViewById(R.id.contactMeBtn)

        personalInformationImageButton.setOnClickListener {
            expandCardView(
                personalInformationImageButton,
                personalInformationExpandable,
                personalInformationCard
            )
        }

        workExperienceImageButton.setOnClickListener {
            expandCardView(
                workExperienceImageButton,
                workExperienceExpandable,
                workExperienceCard
            )
        }

        educationCardImageButton.setOnClickListener {
            expandCardView(
                educationCardImageButton,
                educationExpandable,
                educationCard
            )
        }

        personalSkillsCardImageButton.setOnClickListener {
            expandCardView(
                personalSkillsCardImageButton,
                personalSkillsExpandable,
                personalSkillsCard
            )
        }

        contactMeButton.setOnClickListener {
            ContactMeDialog(this, object : ContactMeDialogListener {
                override fun contactMeEmail() {
                    EmailIntentBuilder.from(applicationContext)
                        .to("zvonimirplivelic91@gmail.com")
                        .subject("Job offer")
                        .start()
                }

                override fun contactMePhone() {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:0955495228")
                    startActivity(intent)
                }
            }).show()
        }
    }

    private fun expandCardView(
        expandButton: ImageButton,
        expandableLayout: LinearLayout,
        expandableCard: CardView
    ) {
        if (expandableLayout.visibility == View.GONE) {
            TransitionManager.beginDelayedTransition(expandableCard, AutoTransition())
            expandableLayout.visibility = View.VISIBLE
            expandButton.setImageResource(R.drawable.ic_up)
        } else {
            TransitionManager.beginDelayedTransition(expandableCard, AutoTransition())
            expandableLayout.visibility = View.GONE
            expandButton.setImageResource(R.drawable.ic_down)
        }
    }
}



