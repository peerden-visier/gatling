/*
 * Copyright 2011-2018 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.http.client;

import io.gatling.http.client.body.RequestBody;
import io.gatling.http.client.proxy.ProxyServer;
import io.gatling.http.client.realm.Realm;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.gatling.http.client.ahc.uri.Uri;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.resolver.NameResolver;

import java.net.InetAddress;
import java.util.List;

public class Request {

  private final HttpMethod method;
  private final Uri uri;
  private final HttpHeaders headers;
  private final List<Cookie> cookies;
  private final RequestBody<?> body;
  private final long requestTimeout;
  private final String virtualHost;
  private final InetAddress localAddress;
  private final Realm realm;
  private final ProxyServer proxyServer;
  private final SignatureCalculator signatureCalculator;
  private final NameResolver<InetAddress> nameResolver;
  private final boolean http2Enabled;
  private final boolean isAlpnRequired;
  private final boolean isHttp2PriorKnowledge;

  public Request(HttpMethod method,
                 Uri uri,
                 HttpHeaders headers,
                 List<Cookie> cookies,
                 RequestBody<?> body,
                 long requestTimeout,
                 String virtualHost,
                 InetAddress localAddress,
                 Realm realm,
                 ProxyServer proxyServer,
                 SignatureCalculator signatureCalculator,
                 NameResolver<InetAddress> nameResolver,
                 boolean http2Enabled,
                 boolean isAlpnRequired,
                 boolean isHttp2PriorKnowledge) {
    this.method = method;
    this.uri = uri;
    this.headers = headers;
    this.cookies = cookies;
    this.body = body;
    this.requestTimeout = requestTimeout;
    this.virtualHost = virtualHost;
    this.localAddress = localAddress;
    this.realm = realm;
    this.proxyServer = proxyServer;
    this.signatureCalculator = signatureCalculator;
    this.nameResolver = nameResolver;
    this.http2Enabled = http2Enabled;
    this.isAlpnRequired = isAlpnRequired;
    this.isHttp2PriorKnowledge = isHttp2PriorKnowledge;
  }

  public Request copyWithAlpnRequiredAndPriorKnowledge(boolean isAlpnRequired, boolean isHttp2PriorKnowledge) {
    return new Request(
      this.method,
      this.uri,
      this.headers,
      this.cookies,
      this.body,
      this.requestTimeout,
      this.virtualHost,
      this.localAddress,
      this.realm,
      this.proxyServer,
      this.signatureCalculator,
      this.nameResolver,
      this.http2Enabled,
      isAlpnRequired,
      isHttp2PriorKnowledge);
  }

  public HttpMethod getMethod() {
    return method;
  }

  public Uri getUri() {
    return uri;
  }

  public HttpHeaders getHeaders() {
    return headers;
  }

  public List<Cookie> getCookies() {
    return cookies;
  }

  public RequestBody<?> getBody() {
    return body;
  }

  public long getRequestTimeout() {
    return requestTimeout;
  }

  public String getVirtualHost() {
    return virtualHost;
  }

  public InetAddress getLocalAddress() {
    return localAddress;
  }

  public Realm getRealm() {
    return realm;
  }

  public ProxyServer getProxyServer() {
    return proxyServer;
  }

  public SignatureCalculator getSignatureCalculator() {
    return signatureCalculator;
  }

  public NameResolver<InetAddress> getNameResolver() {
    return nameResolver;
  }

  public boolean isHttp2Enabled() {
    return http2Enabled;
  }

  public boolean isAlpnRequired() {
    return isAlpnRequired;
  }

  public boolean isHttp2PriorKnowledge() {
    return isHttp2PriorKnowledge;
  }

  @Override
  public String toString() {
    return "Request{" +
      "method=" + method +
      ", uri=" + uri +
      ", headers=" + headers +
      ", cookies=" + cookies +
      ", body=" + body +
      ", requestTimeout=" + requestTimeout +
      ", virtualHost='" + virtualHost + '\'' +
      ", localAddress=" + localAddress +
      ", realm=" + realm +
      ", proxyServer=" + proxyServer +
      ", signatureCalculator=" + signatureCalculator +
      ", nameResolver=" + nameResolver +
      ", http2Enabled=" + http2Enabled +
      ", isAlpnRequired=" + isAlpnRequired +
      ", isHttp2PriorKnowledge=" + isHttp2PriorKnowledge +
      '}';
  }
}
