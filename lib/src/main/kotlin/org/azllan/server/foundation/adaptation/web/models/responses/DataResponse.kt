package org.azllan.server.foundation.adaptation.web.models.responses

data class DataResponse(
    val data: Response = EmptyListResponse(),
) : Response