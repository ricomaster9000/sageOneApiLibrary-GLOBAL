/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

/**
 * Created by Ricardo on 2017-07-16.
 */
public enum SageOneHttpStatusCode {
    Continue(100),
    SwitchingProtocols(101),
    OK(200),
    Created(201),
    Accepted(202),
    NonAuthoritativeInformation(203),
    NoContent(204),
    ResetContent(205),
    PartialContent(206),
    MultipleChoices(300),
    Ambiguous(300),
    MovedPermanently(301),
    Moved(301),
    Found(302),
    Redirect(302),
    SeeOther(303),
    RedirectMethod(303),
    NotModified(304),
    UseProxy(305),
    Unused(306),
    TemporaryRedirect(307),
    RedirectKeepVerb(307),
    BadRequest(400),
    Unauthorized(401),
    PaymentRequired(402),
    Forbidden(403),
    NotFound(404),
    MethodNotAllowed(405),
    NotAcceptable(406),
    ProxyAuthenticationRequired(407),
    RequestTimeout(408),
    Conflict(409),
    Gone(410),
    LengthRequired(411),
    PreconditionFailed(412),
    RequestEntityTooLarge(413),
    RequestUriTooLong(414),
    UnsupportedMediaType(415),
    RequestedRangeNotSatisfiable(416),
    ExpectationFailed(417),
    UpgradeRequired(426),
    InternalServerError(500),
    NotImplemented(501),
    BadGateway(502),
    ServiceUnavailable(503),
    GatewayTimeout(504),
    HttpVersionNotSupported(505);

    private int ordinalValue;

    SageOneHttpStatusCode(final int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }
}
