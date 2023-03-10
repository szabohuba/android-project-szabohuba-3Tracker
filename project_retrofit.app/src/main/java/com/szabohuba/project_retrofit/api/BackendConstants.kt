package com.szabohuba.project_retrofit.api


object BackendConstants {

    /**
     * Project backend base URL.
     */
    const val BASE_URL = "http://tracker-3track.a2hosted.com/"

    /**
     * Specific URL segments, which will be concatenated with the base URL.
     */
    const val LOGIN_URL = "login"
    const val GET_TASKS_URL = "task/getTasks"
    const val GET_SETTINGS_URL="user"

    /**
     * Header values.
     */
    const val HEADER_TOKEN = "token"
}