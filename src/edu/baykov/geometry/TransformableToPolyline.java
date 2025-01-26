package edu.baykov.geometry;
/**
 * <p>Интерфейс {@code TransformableToPolyline} с методом {@code getPolyline();}, добавляющим возможность получения
 * объекта "ломаная линия" из фигуры.
 * </p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public interface TransformableToPolyline {
    public Polyline getPolyline();
}
