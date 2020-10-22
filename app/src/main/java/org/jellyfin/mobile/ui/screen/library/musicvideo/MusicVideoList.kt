package org.jellyfin.mobile.ui.screen.library.musicvideo

import androidx.compose.foundation.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.jellyfin.apiclient.model.entities.CollectionType
import org.jellyfin.mobile.R
import org.jellyfin.mobile.model.dto.FolderInfo
import org.jellyfin.mobile.model.dto.MusicVideoInfo
import org.jellyfin.mobile.model.dto.UserViewInfo
import org.jellyfin.mobile.ui.BackStackAmbient
import org.jellyfin.mobile.ui.Routing
import org.jellyfin.mobile.ui.screen.library.BaseMediaItem
import org.jellyfin.mobile.ui.utils.GridListFor
import timber.log.Timber

@Composable
fun MusicVideoList(viewModel: MusicVideoViewModel) {
    Timber.d(viewModel.contents.joinToString())
    GridListFor(items = viewModel.contents) { info ->
        when (info) {
            is FolderInfo -> FolderItem(folderInfo = info, modifier = Modifier.fillItemMaxWidth())
            is MusicVideoInfo -> MusicVideoItem(musicVideoInfo = info, modifier = Modifier.fillItemMaxWidth())
        }
    }
}

@Composable
fun FolderItem(folderInfo: FolderInfo, modifier: Modifier = Modifier) {
    val backstack = BackStackAmbient.current
    BaseMediaItem(
        info = folderInfo,
        modifier = modifier,
        imageDecorator = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                horizontalAlignment = Alignment.End,
            ) {
                Icon(
                    asset = vectorResource(R.drawable.ic_folder_white_24dp),
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.4f), CircleShape).padding(6.dp),
                )
            }
        },
        onClick = {
            val info = UserViewInfo(folderInfo.id, folderInfo.name, CollectionType.MusicVideos, folderInfo.imageTags)
            backstack.push(Routing.Library(info))
        },
    )
}

@Composable
fun MusicVideoItem(musicVideoInfo: MusicVideoInfo, modifier: Modifier = Modifier) {
    BaseMediaItem(
        info = musicVideoInfo,
        modifier = modifier,
        imageDecorator = {
            // TODO add watched state
        },
    )
}
