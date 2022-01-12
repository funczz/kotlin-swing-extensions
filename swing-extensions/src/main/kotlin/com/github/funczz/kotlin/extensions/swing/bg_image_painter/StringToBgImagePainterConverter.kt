package com.github.funczz.kotlin.extensions.swing.bg_image_painter

import java.util.*

object StringToBgImagePainterConverter {

    private val PAINTERS: List<IBgImagePainter> = listOf(
        DefaultBgImagePainter,
        CenterBgImagePainter,
        TileBgImagePainter,
        FillBgImagePainter
    )

    /**
     * 名称からインスタンスを取得する。
     * @param value 名称
     * @return Optional 指定された名称に対応するインスタンス。
     */
    fun toBgImagePainter(value: String): Optional<IBgImagePainter> {
        return PAINTERS
            .filter { it.getName() == value }
            .map { it.getInstance() }
            .firstOrNull()
            ?.let { Optional.of(it) } ?: Optional.empty()
    }

    /**
     * 名称からインスタンスを取得する。
     * @param value 名称
     * @return 指定された名称に対応するインスタンス。
     *         インスタンスが存在しない場合は DefaultBgImagePainter から取得したインスタンス。
     */
    fun toBgImagePainterOrDefault(value: String): IBgImagePainter {
        return toBgImagePainter(value = value)
            .orElseGet {
                DefaultBgImagePainter.getInstance()
            }
    }

}