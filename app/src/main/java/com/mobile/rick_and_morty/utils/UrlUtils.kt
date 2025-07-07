package com.mobile.rick_and_morty.utils

/**[extractEpisodeIds] - утилитная ф-ция (helper), которая будет извлекать ID из URL **/
fun extractEpisodeIds(episodeUrls: List<String>): List<Int> {
    return episodeUrls.mapNotNull { url ->
        url.substringAfterLast("/").toIntOrNull()
    }
}
/* 1. substringAfterLast("/") — берёт последнюю часть URL (это и есть ID).
   * Например: "https://.../episode/28" → "28"
  2. toIntOrNull() — безопасно пытается превратить строку в Int.
  * Если строка не число — вернёт null, и .mapNotNull её пропустит.
*/