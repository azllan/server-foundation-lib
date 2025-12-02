package org.azllan.server.foundation.adaptation.error.exceptions

import org.azllan.server.foundation.domain.error.ErrorCode
import org.azllan.server.foundation.domain.error.exceptions.CoreException

class AdaptationException(
    code: ErrorCode,
    message: String? = null,
) : CoreException(code, message)