package org.azllan.server.foundation.domain.error.exceptions

import org.azllan.server.foundation.domain.error.ErrorCode

open class CoreException(
    val code: ErrorCode,
    message: String? = null,
) : RuntimeException(message)