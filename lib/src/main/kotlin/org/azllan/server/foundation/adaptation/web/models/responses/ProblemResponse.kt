package org.azllan.server.foundation.adaptation.web.models.responses

import org.azllan.server.foundation.domain.error.ErrorCode

data class ProblemResponse(
    val type: String = "about:blank",
    val title: String = "An error occurred",
    val status: Int,
    val detail: String,
    val instance: String,
    val code: ErrorCode,
) : Response