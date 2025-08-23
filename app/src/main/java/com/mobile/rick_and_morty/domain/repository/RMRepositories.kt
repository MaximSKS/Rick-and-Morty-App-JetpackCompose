package com.mobile.rick_and_morty.domain.repository

import com.mobile.rick_and_morty.domain.model.Character
import com.mobile.rick_and_morty.domain.model.Episode
import com.mobile.rick_and_morty.domain.model.Location

/**For main screens with paging (Characters screen, Episodes screen, Locations screen) **/
interface CharactersPagingRepository : RMGenericPagingRepository<Character>
interface EpisodesPagingRepository : RMGenericPagingRepository<Episode>
interface LocationsPagingRepository : RMGenericPagingRepository<Location>

/**For details screens (CharacterDetailsScreen, EpisodeDetailsScreen, LocationDetailsScreen)  **/
interface CharacterDetailsRepository : RMGenericDetailsRepository<Character>
interface EpisodeDetailsRepository : RMGenericDetailsRepository<Episode>
interface LocationDetailsRepository : RMGenericDetailsRepository<Location>

/**For list of items in details screens (list of characters in CharacterDetailsScreen, list of episodes in EpisodeDetailsScreen) **/
interface CharacterListRepository : RMGenericListRepository<Character>
interface EpisodeListRepository : RMGenericListRepository<Episode>