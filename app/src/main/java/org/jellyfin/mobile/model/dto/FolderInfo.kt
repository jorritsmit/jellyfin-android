package org.jellyfin.mobile.model.dto

import org.jellyfin.apiclient.model.dto.BaseItemType
import org.jellyfin.apiclient.model.entities.ImageType

data class FolderInfo(
    override val id: String,
    val name: String,
    override val imageTags: Map<ImageType, String>,
) : BaseMediaInfo {
    override val itemType: BaseItemType = BaseItemType.Folder
    override val title: String = name
}
