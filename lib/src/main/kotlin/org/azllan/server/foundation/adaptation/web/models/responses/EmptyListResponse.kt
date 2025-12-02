package org.azllan.server.foundation.adaptation.web.models.responses

data class EmptyListResponse(
    val records: List<String> = emptyList(),
) : Response