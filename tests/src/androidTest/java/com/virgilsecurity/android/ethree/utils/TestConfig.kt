/*
 * Copyright (c) 2015-2019, Virgil Security, Inc.
 *
 * Lead Maintainer: Virgil Security Inc. <support@virgilsecurity.com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     (1) Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 *     (2) Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *     (3) Neither the name of virgil nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.virgilsecurity.android.ethree.utils

import android.support.test.InstrumentationRegistry
import com.virgilsecurity.android.ethree.BuildConfig
import com.virgilsecurity.sdk.crypto.VirgilCrypto
import com.virgilsecurity.sdk.crypto.VirgilPrivateKey
import com.virgilsecurity.sdk.crypto.VirgilPublicKey
import com.virgilsecurity.sdk.utils.ConvertionUtils

class TestConfig {
    companion object {
        val virgilCrypto = VirgilCrypto(false)
        val appId = BuildConfig.APP_ID
        val apiKey: VirgilPrivateKey by lazy {
            virgilCrypto.importPrivateKey(ConvertionUtils.base64ToBytes(BuildConfig.API_PRIVATE_KEY))
                    .privateKey
        }
        val apiPublicKey: VirgilPublicKey by lazy {
            virgilCrypto.importPublicKey(ConvertionUtils.base64ToBytes(BuildConfig.API_PUBLIC_KEY))
        }
        val apiPublicKeyId = BuildConfig.API_PUBLIC_KEY_ID

        val virgilBaseUrl = BuildConfig.VIRGIL_BASE_URL
        const val VIRGIL_CARDS_SERVICE_PATH = "/card/v5/"
        const val KEYKNOX_KEY_POSTFIX = "_keyknox"

        val context = InstrumentationRegistry.getTargetContext()
        val DIRECTORY_PATH = InstrumentationRegistry.getTargetContext().filesDir.absolutePath
        val KEYSTORE_NAME = "virgil.keystore"
    }
}
