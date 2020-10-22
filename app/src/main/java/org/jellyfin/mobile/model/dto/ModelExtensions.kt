package org.jellyfin.mobile.model.dto

import org.jellyfin.apiclient.model.dto.BaseItemDto

fun BaseItemDto.toFolderInfo() = FolderInfo(id, name.orEmpty(), imageTags)
fun BaseItemDto.toAlbumInfo() = AlbumInfo(id, name.orEmpty(), albumArtist.orEmpty(), imageTags)
fun BaseItemDto.toArtistInfo() = ArtistInfo(id, name.orEmpty(), imageTags)
fun BaseItemDto.toSongInfo() = SongInfo(id, albumId, name.orEmpty(), artists?.joinToString().orEmpty(), imageTags)
fun BaseItemDto.toMusicVideoInfo() = MusicVideoInfo(id, name.orEmpty(), imageTags)
