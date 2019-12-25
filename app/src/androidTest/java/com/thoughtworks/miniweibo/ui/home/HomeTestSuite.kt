package com.thoughtworks.miniweibo.ui.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.thoughtworks.miniweibo.R
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class HomeTestSuite {
    @Test
    fun testGoToPostDetailFragment() {
        // Given
        val mockNavController = mock(NavController::class.java)
        val titleScenario = launchFragmentInContainer<HomeTimelineFragment>(null,
            R.style.AppTheme
        )
        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }

        // When
        onView(ViewMatchers.withId(R.id.goto_post_detail)).perform(ViewActions.click())

        // Then
        verify(mockNavController).navigate(HomeTimelineFragmentDirections.actionHomeTimelineFragmentToPostDetailFragment())
    }
}