package org.azllan.server.foundation.adaptation.web.presenters

import org.azllan.server.foundation.adaptation.web.models.responses.ProblemResponse
import org.azllan.server.foundation.domain.error.ErrorCode

interface Presenter {
    fun prepareForFailure(
        type: String = "about:blank",
        title: String = "An error occurred",
        status: Int = 500,
        detail: String = "An error occurred",
        instance: String = "about:blank",
        code: ErrorCode = ErrorCode.UNKNOWN_ERROR,
    ): ProblemResponse {
        return ProblemResponse(
            title = title,
            detail = detail,
            status = status,
            type = type,
            instance = instance,
            code = code,
        )
    }
}