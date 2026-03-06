package one.theaq.mcware.logic

enum class GameStage {
	CLEANUP, // Clean up all the variables before starting
	WAITING_FOR_PLAYERS, // Waiting for players, duh
	STARTING, // Main initialization, should pick micro games from data folder. +may pick some game modifiers
	MICRO_GAME, // Starts micro game from generated micro game list
	MICRO_GAME_END, // Micro game end, check if game speed needs to increase, goes back to MICRO_GAME unless
	SPEED_INCREASE, // Increases instance's tick speed and then goes back to MICRO_GAME
	BOSS_GAME_INTRO, // boss game title, resets tick speed
	BOSS_GAME, // boss game itself
	BOSS_GAME_END, // happens when boss game finishes, should calculate all the scores for the FINAL_SCORES stage
	FINAL_SCORES // shows final scores, goes back to CLEANUP stage after
}