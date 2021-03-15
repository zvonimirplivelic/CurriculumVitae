package com.zvonimirplivelic.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workExperienceCard: CardView = findViewById(R.id.workExperienceCard)
        val educationCard: CardView = findViewById(R.id.educationCard)
        val personalSkillsCard: CardView = findViewById(R.id.personalSkillsCard)

        val workExperienceExpandable: LinearLayout = findViewById(R.id.expandableWorkExperience)
        val educationExpandable: LinearLayout = findViewById(R.id.expandableEducation)
        val personalSkillsExpandable: LinearLayout = findViewById(R.id.expandablePersonalSkills)

        val workExperienceImageButton: ImageButton = findViewById(R.id.workExperienceImageButton)
        val educationCardImageButton: ImageButton = findViewById(R.id.educationImageButton)
        val personalSkillsCardImageButton: ImageButton = findViewById(R.id.personalSkillsImageButton)

        workExperienceImageButton.setOnClickListener {
            expandCardView(workExperienceImageButton, workExperienceExpandable, workExperienceCard)
        }

        educationCardImageButton.setOnClickListener {
            expandCardView(educationCardImageButton, educationExpandable, educationCard)
        }

        personalSkillsCardImageButton.setOnClickListener {
            expandCardView(personalSkillsCardImageButton, personalSkillsExpandable, personalSkillsCard)
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



