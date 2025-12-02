package org.azllan.server.foundation.application.exceptions

import org.azllan.server.foundation.domain.error.ErrorCode
import org.azllan.server.foundation.domain.error.exceptions.CoreException

class ApplicationException(
    code: ErrorCode,
    message: String? = null,
) : CoreException(code, message)