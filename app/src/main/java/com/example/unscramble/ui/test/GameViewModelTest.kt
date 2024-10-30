package com.example.unscramble.ui.test
import com.example.unscramble.data.SCORE_INCREASE
import org.junit.Test
import com.example.unscramble.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse

class GameViewModelTest {
    private val viewModel = GameViewModel()
    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset()  {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)

        currentGameUiState = viewModel.uiState.value
        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Assert that score is updated correctly.
        assertEquals(20, currentGameUiState.score)
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
    }
    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}