package org.azllan.server.foundation.domain.error

enum class ErrorCode(val key: String) {
    UNKNOWN_ERROR("error.unknown.title"),
    FAILED_TO_POST_MESSAGE_TO_QUEUE("error.failed_to_post_message_to_queue.title"),
    FAILED_TO_CREATE_RECORD("error.failed_to_create_record.title"),
    RECORD_NOT_FOUND("error.record_not_found.title"),
    FAILED_TO_UPLOAD_ASSET_TO_STORAGE("error.failed_to_upload_asset_to_storage.title"),
    MISSING_PARENT_ID("error.missing_parent_id.title"),
}