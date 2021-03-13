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

        val workExperienceCardButton: ImageButton = findViewById(R.id.workExperienceImageButton)
        val educationCardButton: ImageButton = findViewById(R.id.educationImageButton)
        val personalSkillsCardButton: ImageButton = findViewById(R.id.personalSkillsImageButton)

        workExperienceCardButton.setOnClickListener {
            if (workExperienceExpandable.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(workExperienceCard, AutoTransition())
                workExperienceExpandable.visibility = View.VISIBLE
                workExperienceCardButton.setImageResource(R.drawable.ic_up)
            } else {
                TransitionManager.beginDelayedTransition(workExperienceCard, AutoTransition())
                workExperienceExpandable.visibility = View.GONE
                workExperienceCardButton.setImageResource(R.drawable.ic_down)
            }
        }

        educationCardButton.setOnClickListener {
            if (educationExpandable.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(educationCard, AutoTransition())
                educationExpandable.visibility = View.VISIBLE
                educationCardButton.setImageResource(R.drawable.ic_up)
            } else {
                TransitionManager.beginDelayedTransition(educationCard, AutoTransition())
                educationExpandable.visibility = View.GONE
                educationCardButton.setImageResource(R.drawable.ic_down)
            }
        }

        personalSkillsCardButton.setOnClickListener {
            if (personalSkillsExpandable.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(personalSkillsCard, AutoTransition())
                personalSkillsExpandable.visibility = View.VISIBLE
                personalSkillsCardButton.setImageResource(R.drawable.ic_up)
            } else {
                TransitionManager.beginDelayedTransition(personalSkillsCard, AutoTransition())
                personalSkillsExpandable.visibility = View.GONE
                personalSkillsCardButton.setImageResource(R.drawable.ic_down)
            }
        }
    }
}



