package com.zvonimirplivelic.curriculumvitae

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.ImageView
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

        val personalInformationImageView: ImageView =
            findViewById(R.id.personalInformationImageView)
        val workExperienceImageView: ImageView =
            findViewById(R.id.workExperienceImageView)
        val educationCardImageView: ImageView =
            findViewById(R.id.educationImageView)
        val personalSkillsCardImageView: ImageView =
            findViewById(R.id.personalSkillsImageView)

        val contactMeButton: Button =
            findViewById(R.id.contactMeBtn)

        personalInformationCard.setOnClickListener {
            expandCardView(
                personalInformationImageView,
                personalInformationExpandable,
                personalInformationCard
            )
        }

        workExperienceCard.setOnClickListener {
            expandCardView(
                workExperienceImageView,
                workExperienceExpandable,
                workExperienceCard
            )
        }

        educationCard.setOnClickListener {
            expandCardView(
                educationCardImageView,
                educationExpandable,
                educationCard
            )
        }

        personalSkillsCard.setOnClickListener {
            expandCardView(
                personalSkillsCardImageView,
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

                override fun closeDialog() {
                    this.closeDialog()
                }
            }).show()
        }
    }

    private fun expandCardView(
        expandImage: ImageView,
        expandableLayout: LinearLayout,
        expandableCard: CardView
    ) {
        if (expandableLayout.visibility == View.GONE) {
            TransitionManager.beginDelayedTransition(expandableCard, AutoTransition())
            expandableLayout.visibility = View.VISIBLE
            expandImage.setImageResource(R.drawable.ic_up)
        } else {
            TransitionManager.beginDelayedTransition(expandableCard, AutoTransition())
            expandableLayout.visibility = View.GONE
            expandImage.setImageResource(R.drawable.ic_down)
        }
    }
}



