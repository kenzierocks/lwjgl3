/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.egl.templates

import org.lwjgl.generator.*
import org.lwjgl.egl.*

val NV_post_sub_buffer = "NVPostSubBuffer".nativeClassEGL("NV_post_sub_buffer", postfix = NV) {
	includeEGLEXT()

	documentation =
		"""
		Native bindings to the $registryLink extension.

		Many EGL client APIs do not support rendering to window surfaces directly, so there is no way to efficiently make small updates to window surfaces.
		Applications that need to perform many small updates must either use the back-buffer preservation flag which forces eglSwapBuffers to copy the entire
		back surface, or redraw the entire back buffer on every update and hope eglSwapBuffers is implemented using buffer-flipping. This extension provides a
		3rd alternative: a function which posts a sub-rectangle of a window surface and preserves the back-buffer contents.

		Requires ${EGL11.core}.
		"""

	IntConstant(
		"",

		"POST_SUB_BUFFER_SUPPORTED_NV" _ 0x30BE
	)

	EGLBoolean(
		"PostSubBufferNV",
		"",

		EGLDisplay.IN("dpy", ""),
		EGLSurface.IN("surface", ""),
		EGLint.IN("x", ""),
		EGLint.IN("y", ""),
		EGLint.IN("width", ""),
		EGLint.IN("height", "")
	)
}