package de.ba.railroad.railroadclient.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import de.ba.railroad.railroadclient.model.RailroadViewModel
import de.ba.railroad.railroadclient.ui.screens.RailroadUiState
import kotlinx.coroutines.delay
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RailRoadViewModelTest {
    private val viewModel = RailroadViewModel()

    @Test
    fun railroadViewModel_ServerTest()  {
        var railroadUiState = viewModel.railroadUiState.value

        Assert.assertEquals(railroadUiState, RailroadUiState.Loading)
    }
}