package org.jellyfin.mobile.model.dto

import org.jellyfin.apiclient.model.dto.BaseItemType
import org.jellyfin.apiclient.model.entities.ImageType

interface BaseMediaInfo {
    val id: String
    val parentId: String?
        get() = null
    val itemType: BaseItemType
    val title: String
    val subtitle: String?
        get() = null
    val imageTags: Map<ImageType, String>
    val watchedState: Boolean?
        get() = null
}
